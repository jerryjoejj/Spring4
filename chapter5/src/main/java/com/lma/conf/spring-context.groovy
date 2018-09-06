package com.lma.conf

import com.lma.dao.LoginLogDao
import org.springframework.core.io.ClassPathResource

beans {
    xmlns context:"http://www.springframework.org/schema/context"

    context.'component-scan' ('base-package': "com.lma.conf") {
        'exclude-filter' ('type': "aspectj", 'expression':'com.lma.conf')
    }

    def stream;
    def config = new Properties();
    try {
        stream = new ClassPathResource();
        config.load();
    } finally {
        if (null != stream) {
            stream.close();
        }
    }

    logDao(LoginLogDao) {
        bean ->
            bean.scope = "prototype"
            bean.initMethod = "init"
            bean.destoryMethod = "destory"
            bean.lazyInit = true
    }

    if ("db" == config.get)

}