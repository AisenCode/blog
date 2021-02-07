package cn.aisencode.www.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import cn.aisencode.www.R;

/**
 * <p>文件描述：<p>
 * <p>作者：Aisen<p>
 * <p>创建时间：2021.2.7 14:37<p>
 * <p>博客地址：www.aisencode.cn<p>
 */
public class HomeFragment extends Fragment{
    private View view;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //第一个参数是子布局，第二个参数是要加载进去的父布局，第三个是否将载入的视图绑定到根视图中
        view = inflater.inflate(R.layout.layout_fragment,container,false);
        textView = view.findViewById(R.id.textView);
        textView.setText(R.string.home);
        return view;
    }
}
