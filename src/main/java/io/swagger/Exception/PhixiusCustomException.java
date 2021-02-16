package io.swagger.Exception;

import io.netty.handler.codec.http.HttpResponse;

public class PhixiusCustomException  extends Exception{
    //throw http status code
    public PhixiusCustomException(){
        super(String.format("Phixius api call error ") );
    }
}
