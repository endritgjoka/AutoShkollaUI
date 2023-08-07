import android.view.LayoutInflater
import androidx.viewpager.widget.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.example.autoshkollaui.R
import com.example.autoshkollaui.presentation.ExamViewPagerModel

class ExamViewPagerAdapter(private val examsList: ArrayList<ExamViewPagerModel>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val itemView = inflater.inflate(R.layout.question_view_pager, container, false)
        val numberOfQuestion = itemView.findViewById<TextView>(R.id.numberOfQuestion)
        val imageQuestion = itemView.findViewById<ImageView>(R.id.image_question)
        val question = itemView.findViewById<TextView>(R.id.question)
        val option1 = itemView.findViewById<CheckBox>(R.id.option1)
        val option2 = itemView.findViewById<CheckBox>(R.id.option2)
        val option3 = itemView.findViewById<CheckBox>(R.id.option3)

        // Set data for the views from examsList[position]
        numberOfQuestion.text = examsList[position].numberOfQuestion
       // imageQuestion.setImageResource(examsList[position].image)
        question.text = examsList[position].question
        option1.text = examsList[position].option1
        option2.text = examsList[position].option2
        option3.text = examsList[position].option3

        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun getCount(): Int {
        return examsList.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }
}
