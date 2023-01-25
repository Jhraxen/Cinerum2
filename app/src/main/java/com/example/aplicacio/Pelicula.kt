package com.example.aplicacio.DB
//la clase película con getters, setters y constructores
class Pelicula {


    var id: Int? = null
    var image: String? = null
    var title: String? = null
    var director: String? = null



    constructor(image: String, title: String, director: String) {
        this.image = image
        this.title = title
        this.director = director
    }
    constructor(id: Int, image: String, title: String, director: String) {
        this.id = id
        this.image = image
        this.title = title
        this.director = director
    }

    fun getTitulo(): String? {
        return title
    }
    @JvmName("getDirector1")
    fun getDirector(): String? {
        return director
    }
    @JvmName("getImage1")
    fun getId(): Int? {
        return id
    }
    @JvmName("getImage1")
    fun getImage(): String? {
        return image
    }
    fun setTitulo(titulo: String?) {
        this.title = titulo
    }
    @JvmName("setDirector1")
    fun setDirector(director: String?) {
        this.director = director
    }
    @JvmName("setImage1")
    fun setImage(image: String?) {
        this.image = image
    }



}