package cz.stanej14.embraceroutine.ui.overview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cz.stanej14.embraceroutine.R
import cz.stanej14.embraceroutine.model.Routine
import java.util.*

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {28/06/17}
 **/
class RoutineAdapter(val routineClickListener: RoutineClickListener) : RecyclerView.Adapter<RoutineAdapter.RoutineViewHolder>() {

    val routineList = ArrayList<Routine>()

    fun setData(list: List<Routine>) {
        routineList.clear()
        routineList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RoutineViewHolder?, position: Int) {
        holder?.bind(routineList[position], routineClickListener)
    }

    override fun getItemCount(): Int = routineList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RoutineViewHolder {
        val inflate = LayoutInflater.from(parent?.context).inflate(R.layout.item_routine, parent, false)
        val routineViewHolder = RoutineViewHolder(inflate)
        return routineViewHolder
    }

    class RoutineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.findViewById(R.id.txt_item_routine_name) as TextView
        val difficulty = itemView.findViewById(R.id.txt_item_routine_difficulty) as TextView

        fun bind(routine: Routine, routineClickListener: RoutineClickListener) {
            name.text = routine.name
            difficulty.text = routine.difficulty.name
            itemView.setOnClickListener { routineClickListener.onRoutineClicked(routine.id) }
        }
    }

    interface RoutineClickListener {
        fun onRoutineClicked(routineId: Long)
    }
}