package features.core.data.local.entity

import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class NoteEntity : RealmObject {

    @PrimaryKey
    var _id: ObjectId = ObjectId()

    var id: String = _id.toHexString()

    var header: String = ""

    var note: String = ""

    var modifyDate: RealmInstant = RealmInstant.now()
}