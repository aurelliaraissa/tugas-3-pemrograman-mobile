package com.filkom.lazylayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.filkom.lazylayout.ui.theme.LazyLayoutTheme

class MainActivity : ComponentActivity() {
    val gadgets = listOf(
        Gadget(1, "Smartphone", "Perangkat komunikasi genggam", R.drawable.smartphone),
        Gadget(2, "Laptop", "Komputer portabel untuk bekerja", R.drawable.laptop),
        Gadget(3, "Tablet", "Perangkat layar sentuh antara hp dan laptop", R.drawable.tablet),
        Gadget(4, "Smartwatch", "Jam tangan pintar pelacak kesehatan", R.drawable.smartphone),
        Gadget(5, "Earbuds", "Perangkat audio nirkabel", R.drawable.earbuds),
        Gadget(6, "Laptop", "Perangkat komputasi portabel", R.drawable.laptop),
        Gadget(7, "Smartphone", "Perangkat komunikasi genggam", R.drawable.smartphone),
        Gadget(8, "Laptop", "Komputer portabel untuk bekerja", R.drawable.laptop),
        Gadget(9, "Tablet", "Perangkat layar sentuh antara hp dan laptop", R.drawable.tablet),
        Gadget(10, "Smartwatch", "Jam tangan pintar pelacak kesehatan", R.drawable.smartphone),
        Gadget(11, "Earbuds", "Perangkat audio nirkabel", R.drawable.earbuds),
        Gadget(12, "Laptop", "Perangkat komputasi portabel", R.drawable.laptop),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyLayoutTheme {
                GadgetList(gadgets)
            }
        }
    }
}

@Composable
fun GadgetItem(gadget: Gadget) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = gadget.imageRes),
                contentDescription = gadget.name,
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = gadget.name, style = MaterialTheme.typography.headlineMedium)
                Text(text = gadget.description, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Composable
fun GadgetList(gadgets: List<Gadget>) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, start = 8.dp, end = 8.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "NIM: 245150401111012",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Nama: Aurellia Raissa Sukmaning Prasetya",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        items(gadgets) { gadget ->
            GadgetItem(gadget)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GadgetListHeader(gadgets: List<Gadget>) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp),
        modifier = Modifier.fillMaxSize().padding(top = 50.dp)
    ) {
        stickyHeader {
            Column(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
            ) {
                Text(
                    text = "GADGET",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
        items(gadgets) { gadget ->
            GadgetItem(gadget)
        }
    }
}

@Composable
fun GadgetGrid(gadgets: List<Gadget>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(gadgets) { gadget ->
            GadgetItem(gadget)
        }
    }
}