package vn.bn.teams.banglaixe.roomdata.learn

import vn.bn.teams.banglaixe.models.Question

interface Contract {
    interface View {
        fun getTopic(list: List<Question>)
    }

    interface Presenter {
        fun insertData(dataModel: MutableList<Question>)
        fun getData(topic: Long,limit :Int)
        fun checkRoomDb():Boolean
    }

    interface OnLoadListener {
        fun onSuccess()
        fun onFailure(e: String)
    }
}
