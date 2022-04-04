package fr.upshift.demo;

import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
public class LivenessProbe implements HealthCheck {

    @Inject
    StatusService status;

    @Override
    public HealthCheckResponse call() {
        if (status.isFailed)
            return HealthCheckResponse.down("I'm dead");
        else
            return HealthCheckResponse.up("I'm alive");
    }

}