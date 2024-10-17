package com.example.olimpoapi.repository.accessFlow;

import com.example.olimpoapi.config.exception.ExceptionThrower;
import com.example.olimpoapi.model.redis.Solicitation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class SolicitationRepository {
    private final RedisTemplate<String, Solicitation> redisTemplate;

    public SolicitationRepository(RedisTemplate<String, Solicitation> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(Solicitation solicitation) {
        try {
            redisTemplate.opsForValue().set(solicitation.getId().toString(), solicitation);
        } catch (Exception e) {
            ExceptionThrower.throwBadRequestException(e.getMessage());
        }
    }

    public List<Solicitation> getAll() {
        List<Solicitation> o = redisTemplate.opsForValue().multiGet(Collections.singleton("all"));
        if (o == null) {
            ExceptionThrower.throwNotFoundException("Solicitation not found");
        }
        return o;
    }
    public List<Solicitation> getAllByCommunityId(String communityId) {
        List<Solicitation> o = redisTemplate.opsForValue().multiGet(Collections.singleton(communityId));
        if (o == null) {
            ExceptionThrower.throwNotFoundException("Solicitation not found");
        }
        return o;

    }

    public Solicitation findById(Long id) {
        Solicitation o = redisTemplate.opsForValue().get(id.toString());
        if (o == null) {
            ExceptionThrower.throwNotFoundException("Solicitation not found");
        }
        return o;
    }

    public void deleteById(Long id) {
        redisTemplate.delete(id.toString());
    }
}
