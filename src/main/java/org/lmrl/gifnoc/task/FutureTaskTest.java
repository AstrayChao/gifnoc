package org.lmrl.gifnoc.task;

import org.lmrl.gifnoc.common.utils.JsonUtil;
import org.lmrl.gifnoc.repository.entity.User;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

interface Listener {
    void watchConf(String content) throws InterruptedException;

    Executor getExecutor();
}

class ConfigServer {

    void addListener(String dataId, String group, Listener listener) throws InterruptedException {
        String content = getBy(dataId, group);
        listener.watchConf(content);
    }

    private String getBy(String data, String group) {
        return JsonUtil.toJson(new User(data, group, "12321", 0));
    }
}


public class FutureTaskTest {
    private static final AtomicReference<User> user = new AtomicReference<>(new User());
    public static String data;

    public static void main(String[] args) {

    }
}