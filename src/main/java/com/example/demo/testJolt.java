package com.example.demo;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.ChainrFactory;
import com.bazaarvoice.jolt.JsonUtils;

public class testJolt {
    public static void main(String[] args) {
        Chainr chainr = ChainrFactory.fromClassPath("/spec.json");

        Object output = chainr.transform( JsonUtils.classpathToObject("/input.json") );

        System.out.println("output: \n"+JsonUtils.toPrettyJsonString(output));
    }

}
