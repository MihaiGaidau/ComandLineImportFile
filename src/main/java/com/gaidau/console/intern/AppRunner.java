package com.gaidau.console.intern;

import com.gaidau.console.intern.service.CommandLineService;
import com.gaidau.console.intern.service.LineCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class AppRunner implements CommandLineRunner {

    private Map<LineCommand, CommandLineService> map;

    //    @Autowired
    public AppRunner(List<CommandLineService> services) {
        this.map = services.stream().collect(Collectors.toMap(CommandLineService::getLineCommand, Function.identity()));
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            switch (args[0]) {
                case "READ":
                    map.get(LineCommand.READ).run(Arrays.copyOfRange(args, 1, args.length));
                    break;
                case "EXPORT":
                    map.get(LineCommand.EXPORT).run(Arrays.copyOfRange(args, 1, args.length));
                    break;
                default:
                    System.out.println("Unknown service: " + args[0]);
                    break;
            }
        } else {
            System.out.println("No service specified. Available services: serviceA, serviceB, serviceC");
        }
    }
}