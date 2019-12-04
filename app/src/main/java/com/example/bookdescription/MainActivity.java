package com.example.bookdescription;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TableLayout mTableLayout;
    ArrayList<Desc> lists = new ArrayList<Desc>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String json = "{\n" +
                "  \"Desc\": [\n" +
                "    {\n" +
                "      \"name\": \"Managing Humans: Biting and Humorous Tales of a Software Engineering Manager\",\n" +
                "      \"author\": \" Michael Lopp\",\n" +
                "      \"description\": \"Managing people is difficult wherever you work, but the tech industry as a whole is pretty bad at it. Tech companies in general lack the experience, tools, texts, and frameworks to do it well. And the handful of books that share tips and tricks of engineering management don t explain how to supervise employees in the face of growth and change.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \" The Robert C. Martin Clean Code Collection (Collection) \",\n" +
                "      \"author\": \" Robert C. Martin\",\n" +
                "      \"description\": \"Clean Code: A Handbook of Agile Software Craftmanship The Clean Coder: A Code of Conduct for Professional Programmers In Clean Code, legendary software expert Robert C. Martin has teamed up with his colleagues from Object Mentor to distill their best agile practice of cleaning code \"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \" Julian Assange - The Unauthorised Autobiography \",\n" +
                "      \"author\": \"Julian Assange\",\n" +
                "      \"description\": \"In December 2010, Julian Assange signed a contract with Canongate Books to write a book - part memoir, part manifesto - for publication the following year. At the time, Julian said: 'I hope this book will become one of the unifying documents of our generation. In this highly personal work, I explain our global struggle to force a new relationship between the people\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \" The Future of the Internet--And How to Stop It \",\n" +
                "      \"author\": \"Jonathan L. Zittrain\",\n" +
                "      \"description\": \"This extraordinary book explains the engine that has catapulted the Internet from backwater to ubiquity—and reveals that it is sputtering precisely because of its runaway success. With the unwitting help of its users, the generative Internet is on a path to a lockdown, ending its cycle of innovation—and facilitating unsettling new kinds of control.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \" The Art of Deception: Controlling the Human Element of Security \",\n" +
                "      \"author\": \" Kevin D. Mitnick\",\n" +
                "      \"description\": \"The world's most infamous hacker offers an insider's view of the low-tech threats to high-tech security Kevin Mitnick's exploits as a cyber-desperado and fugitive form one of the most exhaustive FBI manhunts in history and have spawned dozens of articles, books, films, and documentaries. Since his release from federal prison, in 1998, Mitnick has turned his life around \"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \" Systems Engineering and Analysis \",\n" +
                "      \"author\": \"Benjamin S. Blanchard\",\n" +
                "      \"description\": \"In dedicating this text to those graduating with interdisciplinary masters degrees in systems engineering from their school, Blanchard and Fabrycky (Virginia Polytechnic Institute and U.) signal a field encompassing domains such as: communications, healthcare, manufacturing, and transportation.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \" Computation: Finite and Infinite Machines (Automatic Computation) \",\n" +
                "      \"author\": \"Marvin Minsky\",\n" +
                "      \"description\": \"Secure Multi-Party Computation (MPC) is one of the most powerful tools developed by modern cryptography: it facilitates collaboration among mutually distrusting parties by implementing a virtual trusted party. Despite the remarkable potential of such a tool, and decades of active research in the theoretical cryptography community, it remains a relatively inaccessible.\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        try {
            JSONObject obj = new JSONObject(json);
            JSONArray desc = obj.getJSONArray("Desc");
            mTableLayout = (TableLayout) findViewById(R.id.table_layout);
            mTableLayout.setStretchAllColumns(true);

            for (int i = 0; i < desc.length(); i++) {
                JSONObject jsonObject = desc.getJSONObject(i);
                String name = jsonObject.getString("name");
                TableRow tableRow = new TableRow(this);
                Button button = new Button(this);
                button.setTag(i);
                button.setOnClickListener(this);
                button.setWidth(1000);
                button.setHeight(150);
                button.setText(name);
                Desc d = new Desc(jsonObject.getString("name"),jsonObject.getString("author"),jsonObject.getString("description"));
                lists.add(d);
                tableRow.addView(button);
                mTableLayout.addView(tableRow, new TableLayout.LayoutParams());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
//
//        mTableLayout = (TableLayout) findViewById(R.id.table_layout);
//        mTableLayout.setStretchAllColumns(true);
//        for (int i = 0; i < 50; i++) {
//            TableRow tableRow = new TableRow(this);
//            Button button = new Button(this);
//            button.setTag(i);
//            button.setOnClickListener(this);
//            button.setWidth(1000);
//            button.setHeight(150);
//            button.setText("name");
//            tableRow.addView(button);
//            mTableLayout.addView(tableRow, new TableLayout.LayoutParams());
//        }
//
//
//        mTableLayout= (TableLayout) findViewById(R.id.table_layout);
//        mTableLayout.setStretchAllColumns(true);
//        // mTableLayout.setBackgroundResource(R.color.blue);
//
//        int counter = 1;
//        for(int row=0;row<3;row++) {
//            TableRow tableRow=new TableRow(this);
//            for(int col=0;col<3;col++) {
//
//                Button button=new Button(this);
//
//                button.setTag(counter);
//
//                //button.setText(row+","+col+"\nTag:"+button.getTag());
//
//                button.setOnClickListener(this);
//                button.setWidth(300);
//                button.setHeight(300);
//                button.setTextSize(40);
//
//                tableRow.addView(button);
//
//                counter++;
//
//            }
//
//            mTableLayout.addView(tableRow, new TableLayout.LayoutParams());
//        }
//
    }


    public void onClick(View v) {
        Intent intent = new Intent(this,Main2Activity.class);
        int index = Integer.valueOf(v.getTag().toString());
        Desc d = lists.get(index);
        intent.putExtra("name",d.getName());
        intent.putExtra("author",d.getAuthor());
        intent.putExtra("description",d.getMdescrition());
        startActivity(intent);
    }

}
