package com.example.deneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deneme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var takimList : ArrayList<Takimlar>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        takimList = ArrayList<Takimlar>()
        //adapter


        val gs = Takimlar("Galatasaray", R.drawable.gs,"GALATASARAY 1905")
        val fb = Takimlar("Fenerbahçe",R.drawable.fb,"FENERBAHÇE 1907")
        val bjk = Takimlar("Beşiktaş",R.drawable.bjk,"BEŞİKTAŞ 1903")
        val ts = Takimlar("Trabzonspor",R.drawable.ts,"TRABZONSPOR 1967")


        takimList.add(gs)
        takimList.add(fb)
        takimList.add(bjk)
        takimList.add(ts)

        /*  burayı yorum satırı haline getirdim çünkü bu listview artık kullanışsız biz recyclerview için ayrı adapter oluşturcaz onu da yeni sınıf açarak yapcaz
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,takimList.map { Takimlar -> Takimlar.name})
        binding.listView.adapter = adapter
        //tıklandığında ne olacak
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(MainActivity@this,Details::class.java)
            intent.putExtra("detaylaricinintent",takimList.get(position))
            startActivity(intent) } //Details'e gidip bu bilgileri almak için orada da intent oluşturuyoruz */
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val recyclerAdapteri = Recycler_Adapteri(takimList)
        binding.recyclerView.adapter = recyclerAdapteri

    }
}