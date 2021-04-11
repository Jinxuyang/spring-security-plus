package com.verge.springsecurityplus.authentication.imagevalidatecode.properties;

/**
 * @Author Verge
 * @Date 2021/4/9 16:21
 * @Version 1.0
 */
public class ImageValidateCodeProperties {
    private ImageProperties image = new ImageProperties();
    private int expireIn = 600;
    private String url = "/login";
    private String method = "POST";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ImageProperties getImage() {
        return image;
    }

    public void setImage(ImageProperties image) {
        this.image = image;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public static class ImageProperties {
        int width = 60;

        int height = 20;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}



