package com.project.revshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "userdetails")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    
    @NotBlank(message = "userName is required")
    private String userName; 
    
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Email must be valid")
    @NotBlank(message = "Email is required.")
    @Column(unique=true)
    private String userEmail;

    @NotBlank(message = "Password is required.")
    @Size(min = 8, message = "Password must be at least 8 characters.")
    private String userPassword;

    @NotBlank(message = "Role is required.")
    private String userRole;

    @NotBlank(message = "Address is required.")
    private String userAddress;

    @NotNull(message = "Mobile number is required.")
    @Pattern(regexp = "^(\\+\\d{1,3})?\\d{10}$", message = "Mobile number must be valid (e.g., +91XXXXXXXXXX or XXXXXXXXXX)")
    @Column(unique=true)
    private String  userMobileNumber;

    @OneToOne(mappedBy = "usermodel", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private SellerModel sellermodel;

    public UserModel() {
    }

    public UserModel(String userName, String userEmail, String userPassword, String userRole, String userAddress, String userMobileNumber) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.userAddress = userAddress;
        this.userMobileNumber = userMobileNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public SellerModel getSellermodel() {
        return sellermodel;
    }

    public void setSellermodel(SellerModel sellermodel) {
        this.sellermodel = sellermodel;
    }
}
