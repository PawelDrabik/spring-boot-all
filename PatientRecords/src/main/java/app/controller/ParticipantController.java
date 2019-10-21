package app.controller;

import app.domain.Participant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Participant Controller", description = "Operations for adding/listing are present here.")
public class ParticipantController {
    private static final Logger log = LoggerFactory.getLogger(ParticipantController.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ApiOperation(value = "Adding a new participant", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added a new participant"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping(value = "/addParticipant", headers = "Accept=application/json")
    public String addParticipant(@RequestBody Participant participant) {
        log.info("Adding new Participant into a mem db: Participant[" +
                participant.getName() + "," +
                participant.getAge() + "," +
                participant.getHeight() + "," +
                participant.getWeight() + "," +
                participant.getBloodPressure() + "]");

        jdbcTemplate.update("INSERT INTO participants(name, age, height, weight, bloodPressure) " +
                        "VALUES (?,?,?,?,?)", participant.getName(),
                participant.getAge(),
                participant.getHeight(),
                participant.getWeight(),
                participant.getBloodPressure());

        return "{\"participantAdded\": \"OK\"}";
    }

    @ApiOperation(value = "Getting all the participants", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully got a list of all the participants"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/getParticipants", headers = "Accept=application/json")
    public String getParticipants() {
        JSONArray participants = new JSONArray();

        jdbcTemplate.query(
                "SELECT name, age, height, weight, bloodPressure FROM participants",
                (rs, rowNum) ->
                        new Participant(
                                rs.getString("name"),
                                rs.getString("age"),
                                rs.getString("height"),
                                rs.getString("weight"),
                                rs.getString("bloodPressure"))
        ).forEach(participant -> {
            JSONObject json = new JSONObject();
            json.put("name", participant.getName());
            json.put("age", participant.getAge());
            json.put("height", participant.getHeight());
            json.put("weight", participant.getWeight());
            json.put("bloodPressure", participant.getBloodPressure());
            participants.put(json);
        });

        JSONObject response = new JSONObject();
        response.put("participants", participants);

        return response.toString();
    }
}
