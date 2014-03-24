package com.exchange.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.exchange.R;
import com.exchange.adapters.BanksAdapter;
import com.exchange.dao.Bank;
import com.exchange.dao.Course;
import com.exchange.data.Repository;
import com.exchange.rest.RestService;
import com.exchange.util.OnBanksDownloaded;
import com.exchange.widgets.CourseSelectorView;

import java.util.List;

/**
 * @author vlad.fargutu
 */
public class ExchangeFragment extends Fragment implements OnBanksDownloaded {

    private CourseSelectorView courseSelectorView;
    private ListView banksList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.exchange_fragment_layout, container, false);

        assert root != null;
        View selectors = root.findViewById(R.id.course_selector);
        banksList = (ListView) root.findViewById(R.id.banks_list);
        courseSelectorView = selectors != null ? (CourseSelectorView) selectors : null;

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new RestService(getActivity()).doWork(ExchangeFragment.this);
//    initMembers();
    }

    private void initMembers() {
        Repository repository = new Repository(getActivity());
        List<Course> courses = repository.getAll(Course.class);
        List<Bank> banks = repository.getAll(Bank.class);
        repository.closeDb();
        repository = null;

        if (courses != null && courseSelectorView != null) {
            Course course = new Course();
            course.setCode("RON");
            courses.add(course);
            courseSelectorView.setCourses(courses);
        }

        assert banks != null;
        initBanksList(banks);
    }

    private void initBanksList(List<Bank> banks) {
        banksList.setAdapter(new BanksAdapter(getActivity(), banks));
    }

    @Override
    public void onBanksDownloaded() {
        initMembers();
    }
}
