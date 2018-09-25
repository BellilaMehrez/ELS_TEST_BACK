package com.els.test.service.impl;

import com.els.test.domain.Salaried;
import com.els.test.repository.SalariedRepository;
import com.els.test.service.SalariedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Transactional
public class SalariedServiceImp implements SalariedService {

    private final Logger log = LoggerFactory.getLogger(SalariedServiceImp.class);

    @Autowired
    private SalariedRepository salariedRepository;

    /**
     * getAllSalarieds : retrieve list of all salarieds.
     *
     * @return the list of All salaried
     */
    @Override
    public List<Salaried> getAllSalarieds() {
        List<Salaried> salariedList = salariedRepository.findAll();
        return salariedList;
    }

    /**
     * getAllSalariedsNoDuplicateByCreteria : retrieve list fo salaried not duplicated.
     *
     * @param key (String) : key filter
     * @return the list of salaried no duplicated
     */
    @Override
    public List<Salaried> getDistinctByKey(String key) {
        List<Salaried> distinctSalarieds = salariedRepository.findAll().stream().
                filter(distinctByKey(s -> getValues(s, key))).collect(Collectors.toList());
        return distinctSalarieds;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static String getValues(Salaried salaried, String key) {
        switch (key){
            case "fullName":
                return salaried.getFullName();
            case "category":
                return  salaried.getCategory();
            case "description":
                return  salaried.getDescription();
            case "address":
                return  salaried.getAddress();
            default: return  "";
        }
    }

}
