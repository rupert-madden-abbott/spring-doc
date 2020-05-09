package com.maddenabbott.sdmp;

import com.maddenabbott.spdg.Generator;
import com.maddenabbott.spdg.util.PathUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.nio.file.Paths;

@Mojo(name = "generate")
public class GenerateMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project.build.outputDirectory}/META-INF/spring-configuration-metadata.json")
    private String inputFileName;

    @Parameter(defaultValue = "${project.basedir}/CONFIG.MD")
    private String outputFileName;

    @Override
    public void execute() {
        PathUtils.write(Paths.get(outputFileName), Generator.getDefault().generate(inputFileName));
    }
}
