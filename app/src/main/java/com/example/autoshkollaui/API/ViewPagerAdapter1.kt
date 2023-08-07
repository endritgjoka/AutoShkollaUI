import android.view.LayoutInflater
import androidx.viewpager.widget.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.autoshkollaui.R
import com.example.autoshkollaui.API.generated_classes.Photo


class ViewPagerAdapter1() : PagerAdapter() {
    private val dataList = ArrayList<Photo>()

    public fun setList(data: ArrayList<Photo>){
        dataList.clear()
        dataList.addAll(data)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val inflater = LayoutInflater.from(container.context)
        val itemView = inflater.inflate(R.layout.question_view_pager, container, false)
        val numberOfQuestion = itemView.findViewById<TextView>(R.id.numberOfQuestion)
        val imageQuestion = itemView.findViewById<ImageView>(R.id.image_question)
        val question = itemView.findViewById<TextView>(R.id.question)
        val option1 = itemView.findViewById<CheckBox>(R.id.option1)
        val option2 = itemView.findViewById<CheckBox>(R.id.option2)
        val option3 = itemView.findViewById<CheckBox>(R.id.option3)


        numberOfQuestion.text = dataList[position].photographer

        val imageUrl = dataList[position].src.original
        Glide.with(itemView.context)
            .load(imageUrl)
            .into(imageQuestion)

        question.text = dataList[position].alt
        option1.text = dataList[position].photographer
        option2.text = dataList[position].alt
        option3.text = dataList[position].alt


        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun getCount(): Int {
        return dataList.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }
}
