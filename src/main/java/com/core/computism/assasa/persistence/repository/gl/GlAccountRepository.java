package com.core.computism.assasa.persistence.repository.gl;

import com.core.computism.assasa.persistence.entity.gl.admin.GlAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VD on 2/27/2016.
 */
public interface GlAccountRepository extends JpaRepository<GlAccount,Long> {
}
