package com.example.demo.dto;

public class VtoRequest {
    private String email;
    private String password;
    private String modelPhoto;
    private String clothingPhoto;
    private String ratio;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModelPhoto() {
        return modelPhoto;
    }

    public void setModelPhoto(String modelPhoto) {
        this.modelPhoto = modelPhoto;
    }

    public String getClothingPhoto() {
        return clothingPhoto;
    }

    public void setClothingPhoto(String clothingPhoto) {
        this.clothingPhoto = clothingPhoto;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }
}
