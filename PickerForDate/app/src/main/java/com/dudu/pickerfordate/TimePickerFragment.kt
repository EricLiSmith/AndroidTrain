package com.dudu.pickerfordate


import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.widget.TimePicker
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return TextView(activity).apply {
//            setText(R.string.hello_blank_fragment)
//        }
//    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(activity, this, hour, minute, true)

//        return super.onCreateDialog(savedInstanceState)
    }


    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        //To change body of created functions use File | Settings | File Templates.
        val mainActivity = activity as MainActivity

        mainActivity.processTimePickerResult(hourOfDay, minute)
    }
}
