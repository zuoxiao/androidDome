// IUserAidlInterface.aidl
package com.zuo.nfcproject.mylibrary;

// Declare any non-default types here with import statements

interface User2 {
 void addUser(in User user);
    List<User> getUserList();
}