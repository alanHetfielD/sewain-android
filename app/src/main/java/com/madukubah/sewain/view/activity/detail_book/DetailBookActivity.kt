package com.madukubah.sewain.view.activity.detail_book

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.Layout.JUSTIFICATION_MODE_INTER_WORD
import com.madukubah.sewain.R
import com.madukubah.sewain.model.Book
import com.madukubah.sewain.view.dialog.sewa.DialogSewaFragment
import kotlinx.android.synthetic.main.activity_detail_book.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast

class DetailBookActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_book)

        book = intent.getParcelableExtra(BOOK)

        tv_book_title.text = book.book_title
        tv_book_author.text = book.book_author
        tv_book_page_count.text = book.book_page_count
        tv_book_desc.text = book.book_desc

//        tv_book_desc.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD)

        btn_sewa.onClick {
            val dialogSewaFragment : DialogSewaFragment = DialogSewaFragment(){
                when( it ){
                    0->{
//                        toast("telepon")
                        val dialPhoneIntent = Intent( Intent.ACTION_DIAL, Uri.parse("tel:" + "123412341234" ))
                        startActivity(dialPhoneIntent)
                    }
                    1->{
//                        toast("SMS")
                        sendSMS()
                    }
                }
            }
            val ft = getSupportFragmentManager().beginTransaction()
            dialogSewaFragment.show(ft , "doalog")
        }
    }
    private fun sendSMS()
    {   val tx = "betul ini dengan pemilik buku \" " + book.book_title+ " \" ? saya tertarik untuk menyewa buku anda \n\n Sms Via Sewain App"
        val i = Intent( Intent.ACTION_VIEW, Uri.fromParts("sms", "" + "123412341234"  , this.toString()) )
        i.putExtra("sms_body", tx )

        try {
            startActivity( i )
            finish()
            toast("buka sms ")
        } catch (e: Exception) {
            toast("gagal mengirim sms")
        }
    }

    companion object {
        const val BOOK = "BOOK"
    }

    lateinit var book : Book

}
