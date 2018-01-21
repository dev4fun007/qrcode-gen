package qrcode.controller;


import com.google.zxing.WriterException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import qrcode.generate.ZXingHelper;

import java.io.IOException;

@RestController
public class QRCodeController {


    @RequestMapping(value = "/qrcode",
            method = RequestMethod.POST,
            consumes = "text/plain",
            produces = {MediaType.IMAGE_PNG_VALUE, MediaType.APPLICATION_JSON_VALUE})

    public @ResponseBody byte[] generateQRCode(@RequestBody String payload,
                                                 @RequestParam("width") String width,
                                                 @RequestParam("height") String height)
    {

        byte[] qrcode = null;

        //check if any data is present or not
        if(payload.isEmpty())
            payload = "May be you forgot to send text!";

        try {
            qrcode = ZXingHelper.generateQRCode(payload, Integer.parseInt(width), Integer.parseInt(height));
        }
        catch (IOException | WriterException | NumberFormatException e)
        {
            System.out.println("Exception occurred, "+e.getLocalizedMessage());
            if(e instanceof NumberFormatException)
                throw new NumberFormatException();
            else
                throw new IllegalStateException();
        }
        return qrcode;
    }

}
