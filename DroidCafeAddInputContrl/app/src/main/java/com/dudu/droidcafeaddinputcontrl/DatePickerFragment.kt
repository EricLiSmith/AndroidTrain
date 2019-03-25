package com.dudu.droidcafeaddinputcontrl


import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.widget.DatePicker
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

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
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(activity, this, year, month, day)
//        return super.onCreateDialog(savedInstanceState)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        //To change body of created functions use File | Settings | File Templates.
        val mainActivity = activity as MainActivity
        mainActivity.processDatePickerResult(year, month+1, dayOfMonth)
    }


}
