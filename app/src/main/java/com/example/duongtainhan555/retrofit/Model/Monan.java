package com.example.duongtainhan555.retrofit.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Monan {

@SerializedName("id")
@Expose
private String id;
@SerializedName("tenmonan")
@Expose
private String tenmonan;
@SerializedName("giamonan")
@Expose
private String giamonan;
@SerializedName("hinhanh")
@Expose
private String hinhanh;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getTenmonan() {
return tenmonan;
}

public void setTenmonan(String tenmonan) {
this.tenmonan = tenmonan;
}

public String getGiamonan() {
return giamonan;
}

public void setGiamonan(String giamonan) {
this.giamonan = giamonan;
}

public String getHinhanh() {
return hinhanh;
}

public void setHinhanh(String hinhanh) {
this.hinhanh = hinhanh;
}

}


