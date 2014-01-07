package com.mycompany.sertest.common;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Created with IntelliJ IDEA.
 * User: dart
 * Date: 24.10.12
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 */
public final class KryoSerializer {

    private static final Kryo kryo = new Kryo();

    static {
        kryo.setRegistrationRequired(false);
    }

    public static void register(Class... classes) {
        for(Class clazz : classes) {
            kryo.register(clazz);
        }
    }

    public static byte[] write(Object obj) {
        Output output = new Output(512, 1024 * 8);
        kryo.writeClassAndObject(output, obj);
        return output.getBuffer();
    }

    public static Object read(byte[] bytes) {
        return kryo.readClassAndObject(new Input(bytes));
    }
}