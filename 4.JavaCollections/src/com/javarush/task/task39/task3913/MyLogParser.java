package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MyLogParser implements IPQuery {

    private Path path;
    private List<String> list = new ArrayList<>();
    private List<Message> listMessage = new ArrayList<>();

    public MyLogParser(Path logDir) {
        this.path = logDir;
        parthLogs();
    }

    public int getNumberOfUniqueIPs(Date after, Date before) {
        return filterWithDate1AndDate2(after, before).stream().map(s -> s.ip).collect(Collectors.toSet()).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return filterWithDate1AndDate2(after, before).stream().map(s -> s.ip).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return filterWithDate1AndDate2(after, before).stream().filter(us -> us.name.equals(user)).map(s -> s.ip).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return filterWithDate1AndDate2(after, before).stream().filter(us -> us.event.equals(event)).map(s -> s.ip).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return filterWithDate1AndDate2(after, before).stream().filter(us -> us.status.equals(status)).map(s -> s.ip).collect(Collectors.toSet());
    }

    public Set<Message> filterWithDate1AndDate2(Date after, Date before) {
        if (after == null && before == null) {
            return new HashSet<>(listMessage);
        }
        Set<Message> lisrExit = new HashSet<>();
        for (Message mes : listMessage) {
            if (after == null) {
                if (mes.date.before(before)) lisrExit.add(mes);
                continue;
            }
            if (before == null) {
                if (mes.date.after(after)) lisrExit.add(mes);
                continue;
            }
            if (mes.date.after(after) && mes.date.before(before)) lisrExit.add(mes);
        }
        return lisrExit;
    }

    public void parthLogs() {
            /*List<File> listFiles = Files.walk(path)
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());

            for (File file:listFiles) {
               Files.lines(file.toPath()).forEach(s->list.add(s));
            }*/
        try {
            Files.walk(path).filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList()).forEach(str -> {
                try {
                    Files.lines(str.toPath()).forEach(s -> list.add(s));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String str : list) {
            Matcher m = Pattern.compile("(?<ip>[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3})\t" +
                    "(?<name>([a-zA-z]+)|[a-zA-Z ]+)\t" +
                    "(?<date>\\d{1,2}\\.\\d{1,2}\\.\\d{4} \\d{1,2}:\\d{1,2}:\\d{1,2})\t" +
                    "(?<event>[\\w]+)([\t ])" +
                    "((?<taskNumber>[\\d]+)\t)?" +
                    "(?<status>[\\w]+)").matcher(str);
            try {
                while (m.find()) {
                    if (m.group("taskNumber") == null)
                        listMessage.add(new Message(m.group("ip"),
                                m.group("name"),
                                new SimpleDateFormat("d.M.yyyy HH:mm:ss").parse(m.group("date")),
                                Event.valueOf(m.group("event")),
                                Status.valueOf(m.group("status"))));
                    else
                        listMessage.add(new Message(m.group("ip"),
                                m.group("name"),
                                new SimpleDateFormat("d.M.yyyy HH:mm:ss").parse(m.group("date")),
                                Event.valueOf(m.group("event")),
                                Integer.parseInt(m.group("taskNumber")),
                                Status.valueOf(m.group("status"))));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    class Message {
        String ip;
        String name;
        Date date;
        Event event;
        int taskNumber;
        Status status;

        public Message(String ip, String name, Date date, Event event, Status status) {
            this.ip = ip;
            this.name = name;
            this.date = date;
            this.event = event;
            this.status = status;
        }

        public Message(String ip, String name, Date date, Event event, int taskNumber, Status status) {
            this.ip = ip;
            this.name = name;
            this.date = date;
            this.event = event;
            this.taskNumber = taskNumber;
            this.status = status;
        }

        @Override
        public String toString() {
            return "ip='" + ip + '\'' +
                    ", name='" + name + '\'' +
                    ", date=" + date +
                    ", event=" + event +
                    ", taskNumber=" + taskNumber +
                    ", status=" + status +
                    '}';
        }
    }

}

