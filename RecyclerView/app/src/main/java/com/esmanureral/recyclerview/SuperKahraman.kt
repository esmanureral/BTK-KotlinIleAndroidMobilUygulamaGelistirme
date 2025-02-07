package com.esmanureral.recyclerview

import java.io.Serializable

//Adapter classında intent.putExtra yaparken tip dönüşümünü kolay hala getrimek için serializable  kullandık
//Serialization (Serileştirme), bir nesnenin (object) bellekteki durumunun bayt dizisine dönüştürülerek kaydedilmesi, saklanması veya ağ üzerinden iletilmesi işlemidir.
class SuperKahraman(val isim:String,val meslek:String,val gorsel:Int):Serializable {

}