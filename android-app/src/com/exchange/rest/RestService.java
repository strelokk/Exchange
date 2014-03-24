package com.exchange.rest;

import android.app.ProgressDialog;
import android.content.Context;

import com.exchange.dao.Bank;
import com.exchange.dao.Branch;
import com.exchange.dao.Course;
import com.exchange.dao.CourseValue;
import com.exchange.data.Repository;
import com.exchange.rest.models.JBank;
import com.exchange.rest.models.JBranch;
import com.exchange.rest.models.JCourse;
import com.exchange.rest.models.JCourseValue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ly.apps.android.rest.client.Callback;
import ly.apps.android.rest.client.Response;
import ly.apps.android.rest.client.RestClientFactory;
import ly.apps.android.rest.client.RestServiceFactory;

/**
 * Created by vlad.fargutu on 3/20/14.
 */
public class RestService {

    private Context context;
    private ProgressDialog mProgress;
    private Repository repository;

    public RestService(Context context) {
        super();
        this.context = context;
        mProgress = new ProgressDialog(context);
        repository = new Repository(context);
    }

    public void doWork() {
        mProgress.setMessage("Please wait ...");
        mProgress.setCancelable(false);
        mProgress.setIndeterminate(true);
        mProgress.show();

        String baseUrl = "http://53cd7b22-a3e7-496c-a47c-14e060.appspot.com/rest";
        RestFullAPI api = RestServiceFactory.getService(baseUrl, RestFullAPI.class, RestClientFactory.defaultClient(context));

        getBanks(api);
//        getCourses(api);
//        getCourseValues(api);
    }

    private void getBanks(final RestFullAPI api) {

        api.getBanks(new Callback<List<JBank>>() {

            @Override
            public void onResponse(Response<List<JBank>> response) {
                List<JBank> banks = response.getResult();

                if (banks != null) {

                    for (JBank b : banks) {
                        Bank bank = new Bank();
                        bank.setName(b.getName());
                        bank.setUpdatedDate(new Date());

                        long id = repository.insert(bank);

                        if (id != -1) {
                            insertBranches(id, b.getBranches());
                        }
                    }

                }

                getCourses(api);

            }

        });

    }

    private void getCourses(final RestFullAPI api) {

        api.getCourses(new Callback<List<JCourse>>() {
            @Override
            public void onResponse(Response<List<JCourse>> response) {
                List<JCourse> courses = response.getResult();

                if (courses != null) {
                    for (JCourse c : courses) {
                        Course course = new Course();
                        course.setName(c.getName());
                        course.setCode(c.getCode());

                        repository.insert(course);
                    }
                }

                getCourseValues(api);

            }
        });

    }

    private void getCourseValues(RestFullAPI api) {

        Date d = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = formatter.format(d);

        api.getCourseValues(currentDate, new Callback<List<JCourseValue>>() {
            @Override
            public void onResponse(Response<List<JCourseValue>> response) {
                List<JCourseValue> courseValues = response.getResult();

                if (courseValues != null) {
                    for (JCourseValue c : courseValues) {
                        CourseValue courseValue = new CourseValue();
                        courseValue.setPurchase(c.getPurchaseValue());
                        courseValue.setSale(c.getSaleValue());
                        courseValue.setBankName(c.getBankName());
                        courseValue.setCourseCode(c.getCourseCode());
                        courseValue.setUpdatedDate(new Date());

                        repository.insert(courseValue);
                    }
                }

                onTaskComplete();

            }
        });

    }

    private void insertBranches(long bankId, List<JBranch> branches) {
        for (JBranch b : branches) {
            Branch branch = new Branch();
            branch.setName(b.getName());
            branch.setAddress(b.getAddress());

            try {
                branch.setLatitude(Double.valueOf(b.getLatitude()));
                branch.setLongitude(Double.valueOf(b.getLongitude()));
            } catch (NumberFormatException e) {
                e.getMessage();
            }

            branch.setBankId(bankId);

            repository.insert(branch);
        }
    }

    private void onTaskComplete() {
        if (repository != null) {
            repository.closeDb();
            repository = null;
        }

        if (mProgress != null && mProgress.isShowing()) {
            mProgress.dismiss();
            mProgress = null;
        }
    }
}
