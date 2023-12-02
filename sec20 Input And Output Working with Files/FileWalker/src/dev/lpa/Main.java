package dev.lpa;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
Path startingPath = Path.of(".");
        FileVisitor<Path> statsVisitor = new StatsVisitor(1);
        try {
            Files.walkFileTree(startingPath, statsVisitor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static class StatsVisitor extends SimpleFileVisitor<Path>{
//        private int level;

        private Path initialPath;
        private final Map<Path, Long> folderSizes = new LinkedHashMap<>();
        private int initialCount;
        private int printLevel;

        public StatsVisitor(int printLevel) {
            this.printLevel = printLevel;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);
//            System.out.println("\t".repeat(level + 1) +file.getFileName());
folderSizes.merge(file.getParent(), 0L, (o,n) -> o += attrs.size());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(dir);
            Objects.requireNonNull(attrs);

//            level++;
//            System.out.println("\t".repeat(level) + dir.getFileName());
            if(initialPath == null){
                initialPath = dir;
                initialCount = dir.getNameCount();
            }else {
                int relativeLevel = dir.getNameCount() -initialCount;
                if(relativeLevel == 1){
                    folderSizes.clear();
                }
                folderSizes.put(dir, 0L);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Objects.requireNonNull(dir);
//            if (exc != null)
//                throw exc;
//            level--;
            if(dir.equals(initialPath)){
                return FileVisitResult.TERMINATE;
            }

            int relativeLevel = dir.getNameCount() - initialCount;
            if(relativeLevel == 1){
                folderSizes.forEach((k, v) ->{
                    int level = k.getNameCount() - initialCount -1;
                    if(level < printLevel){
                        System.out.printf("%s[%s] - %,d bytes %n",
                                "\t".repeat(level), k.getFileName(), v);
                    }
                });
            }else {
                long folderSize = folderSizes.get(dir);
                folderSizes.merge(dir.getParent(), 0L, (o,n) -> o += folderSize);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
