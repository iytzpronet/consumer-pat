package com.consumerpat.alelo.Util;

import java.util.ArrayList;
import java.util.Collection;

public class ListaUtil {


    public static <T>Collection<T> nonNull(Collection<T> lista){

        return lista != null ? lista : new ArrayList<>();
    }
}
