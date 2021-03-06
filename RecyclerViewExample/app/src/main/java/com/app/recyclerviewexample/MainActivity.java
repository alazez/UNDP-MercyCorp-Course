package com.app.recyclerviewexample;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        final SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(layoutManager);
        List<Employee> employeeList = new ArrayList();
        employeeList.add(new Employee("ahmed","123"));
        employeeList.add(new Employee("mohammed","41"));
        /*
        employeeList.add(new Employee("osama","41"));
        employeeList.add(new Employee("osama3","41"));
        employeeList.add(new Employee("osama3","41"));
        employeeList.add(new Employee("osama3","41"));
        employeeList.add(new Employee("osama3","41"));
        employeeList.add(new Employee("osama3","41"));
        employeeList.add(new Employee("osama3","41"));
        employeeList.add(new Employee("osama3","41"));
        employeeList.add(new Employee("osama3","41"));
        employeeList.add(new Employee("osama3","41"));
        employeeList.add(new Employee("osama3","41"));
        */
        final MyRecyclerAdapter adapter = new MyRecyclerAdapter(this,employeeList);

        adapter.setiClickListener(new MyRecyclerAdapter.IClickListener() {
            @Override
            public void onItemClick(int position, Employee employee) {
                Toast.makeText(MainActivity.this, employee.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);
        /*
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        */

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(MainActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();
                adapter.addEmployee(new Employee("new","321"));
                swipeRefreshLayout.setRefreshing(false);

            }
        });
    }


}
