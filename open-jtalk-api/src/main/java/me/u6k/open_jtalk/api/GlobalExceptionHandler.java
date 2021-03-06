
package me.u6k.open_jtalk.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger L = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<String> handle(IllegalArgumentException e) {
        L.warn("#handle: " + e.toString());

        return ResponseEntity.badRequest().body(e.toString());
    }

    @ExceptionHandler(OpenJTalkRuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> handle(OpenJTalkRuntimeException e) {
        L.warn("#handle: " + e.toString());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
    }

    @ExceptionHandler(HttpMediaTypeException.class)
    @ResponseBody
    public ResponseEntity<String> handle(HttpMediaTypeException e) {
        L.warn("#handle: " + e.toString());

        return ResponseEntity.badRequest().body(e.toString());
    }

}
