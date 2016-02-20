package com.core.computism.assasa.util;

import com.core.computism.assasa.exception.BuilderException;
import org.dozer.Mapper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Venturedive on 8/18/2015.
 */
public class DomainEntityBuilder<T> {

    private Class<T> destClass;
    private T destInstance;
    private Mapper mapper;

    private List<Object> sources = new ArrayList<Object>(0);

    public DomainEntityBuilder(Class<T> c, T instance, Mapper mapper) {
        this.destClass = c;
        this.destInstance = instance;
        this.mapper = mapper;
    }

    public T build() throws BuilderException {
        validate(false);
        T result = null;

        if (destInstance != null) {
            result = destInstance;
        }

        try {
            // if T is singleton
            for(Object source : sources) {
                try {
                    result = buildInstance(result, source);
                } catch (Exception e) {
                    throw new BuilderException("Mapping from [" + source + "] to [" + destClass + "] message: [" + e.getMessage() + "]", e);
                }
            }
            return result;

        } catch (Exception e) {
            throw new BuilderException(e);
        } finally {
            reset();
        }
    }

    public List<T> buildList() throws BuilderException {
        validate(true);
        List<T> result = new ArrayList<T>();

        try {
            for (Object source : sources) {
                if (Collection.class.isAssignableFrom(source.getClass())) {
                    for (Object obj : (Collection<?>)source) {
                        result.add(buildInstance(obj));
                    }
                } else if (source.getClass().isArray()) {
                    int len = Array.getLength(source);

                    for (int i = 0; i < len; i++) {
                        Object obj = Array.get(source, i);
                        if (obj != null) {
                            result.add(buildInstance(obj));
                        }
                    }
                } else {
                    result.add(buildInstance(source));
                }
            }
        } catch (Exception e) {
            throw new BuilderException("Mapping from sources[" + sources + "] to destClass [" + destClass + "]", e);
        } finally {
            reset();
        }
        return result;

    }

    private void validate(boolean validateCollection) throws BuilderException {
        if (destClass == null) {
            throw new BuilderException("Destination class is undefined.");
        }
        if (destClass.isInterface()) {
            throw new BuilderException("Destination class cannot be an interface.");
        }
        if (!validateCollection) {
            if (destClass.isArray()) {
                throw new BuilderException("Destination class cannot be an array type. Use buildList() instead.");
            }
            if (Collection.class.isAssignableFrom(destClass)) {
                throw new BuilderException("Destination class cannot be a collection. Use buildList() instead.");
            }
        }
    }

    private T buildInstance(Object src) throws Exception {
        return buildInstance(null, src);
    }

    private T buildInstance(T result, Object src) throws Exception {
        if (result == null) {
            result = mapper.map(src, destClass);
        } else {
            mapper.map(src, result);
        }
        return result;
    }

    private void reset() {
        this.destInstance = null;
        this.sources.clear();
    }

    public DomainEntityBuilder<T> from(Object source) {
        this.sources.add(source);
        return this;
    }

    public DomainEntityBuilder<T> withInstance(T instance) {
        this.destInstance = instance;
        return this;
    }
}
