package com.application.eventsbooking.factory;

import com.application.eventsbooking.models.Role;
import com.application.eventsbooking.models.User;
import com.application.eventsbooking.services.BusinessEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BusinessEntityFactory {

    private final Map<Role, BusinessEntityService> serviceMap;

    @Autowired
    public BusinessEntityFactory(List<BusinessEntityService> services) {
        this.serviceMap = services.stream()
                .collect(Collectors.toMap(BusinessEntityService::getRole, Function.identity()));
    }

    public BusinessEntityService getBusinessEntityService(User user) {
        BusinessEntityService service = serviceMap.get(user.getRole());
        if (service == null) {
            throw new IllegalArgumentException("Unsupported user role: " + user.getRole());
        }
        return service;
    }
}
