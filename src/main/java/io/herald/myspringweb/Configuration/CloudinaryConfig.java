package io.herald.myspringweb.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name","yjmjv3rk",
                "api_key","672624767812476",
                "api_secret","wo-TCy-7IyN0Nl7794fUkFmOU2U",
                "secure",true
        ));


    }

}
