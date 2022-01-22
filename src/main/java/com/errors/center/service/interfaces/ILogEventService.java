package com.errors.center.service.interfaces;


import com.errors.center.model.LogEvent;

public interface ILogEventService {

    LogEvent saveLog(Object log);
}
