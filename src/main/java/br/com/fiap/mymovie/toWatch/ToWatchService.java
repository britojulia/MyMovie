package br.com.fiap.mymovie.toWatch;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToWatchService {

    private final ToWatchRepository toWatchRepository;

    public ToWatchService(ToWatchRepository toWatchRepository) {
        this.toWatchRepository = toWatchRepository;
    }

    public List<ToWatch> getAllToWatch(){
        return  toWatchRepository.findAll();
    }

    public ToWatch save(ToWatch toWatch){   return toWatchRepository.save(toWatch);
    }
}
