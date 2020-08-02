package com.madhan.listdemo.model


import com.google.gson.annotations.Expose

class ListModel {
    @Expose
    public var title: String? = ""
        get() = field
        set(value) {
            field = value
        }
    @Expose
    public var description: String? = ""
        get() = field
        set(value) {
            field = value
        }
    @Expose
    public var imageHref: String? = ""
        get() = field
        set(value) {
            field = value
        }

}