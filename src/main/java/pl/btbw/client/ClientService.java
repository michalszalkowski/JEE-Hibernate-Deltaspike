package pl.btbw.client;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

@Stateless
public class ClientService {

	public void test() {

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.github.com/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		GitHubService service = retrofit.create(GitHubService.class);

		Call<List<RepoDto>> repos = service.listRepos("szalek");

		try {

			Response<List<RepoDto>> execute = repos.execute();

			List<RepoDto> body = execute.body();

			for (RepoDto repoDto : body) {
				System.out.println(repoDto);
			}

		} catch (IOException e) {

		}
	}

}
