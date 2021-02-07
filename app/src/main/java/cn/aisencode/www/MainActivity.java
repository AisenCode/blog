package cn.aisencode.www;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import cn.aisencode.www.adapter.ViewPagerAdapter;
import cn.aisencode.www.fragment.DynamicFragment;
import cn.aisencode.www.fragment.HomeFragment;
import cn.aisencode.www.fragment.MineFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<Fragment> fragments;
    private HomeFragment homeFragment = new HomeFragment();
    private DynamicFragment dynamicFragment = new DynamicFragment();
    private MineFragment mineFragment = new MineFragment();
    private RadioGroup radioGroup;
    private RadioButton raioHome,radioDynamic,radioMine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        radioGroup = findViewById(R.id.radio_group);
        raioHome = findViewById(R.id.radio_home);
        radioDynamic = findViewById(R.id.radio_dynamic);
        radioMine = findViewById(R.id.radio_mine);
        //创建fragments的list
        fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(dynamicFragment);
        fragments.add(mineFragment);
        //viewPager绑定adapter
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPagerAdapter = new ViewPagerAdapter(fragmentManager,fragments);
        viewPager.setAdapter(viewPagerAdapter);
        //viewPager，radioGroup，初始化选中
        viewPager.setCurrentItem(0);
        radioGroup.check(R.id.radio_home);

        //设置viewPager的Listener中的onPageSelected与radioGroup绑定
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }


            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioGroup.check(R.id.radio_home);
                        break;
                    case 1:
                        radioGroup.check(R.id.radio_dynamic);
                        break;
                    case 2:
                        radioGroup.check(R.id.radio_mine);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //radioGroup设置Listener与viewPager绑定
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.radio_dynamic:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.radio_mine:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });
    }
}
