package net.jolivier.s3api.http;

import org.glassfish.hk2.api.PerLookup;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.ext.Provider;
import net.jolivier.s3api.model.User;

@Provider
public class ProjectFeature implements Feature {

	@Override
	public boolean configure(FeatureContext context) {

		context.register(new AbstractBinder() {
			@Override
			protected void configure() {
				bindFactory(S3UserFactory.class).to(User.class).proxy(false).proxyForSameScope(true)
						.in(PerLookup.class);

			}
		});

		return true;

	}
}