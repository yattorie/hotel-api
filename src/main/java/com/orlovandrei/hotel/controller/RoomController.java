package com.orlovandrei.hotel.controller;

import com.orlovandrei.hotel.entity.room.Room;
import com.orlovandrei.hotel.service.RoomService;
import com.orlovandrei.hotel.dto.room.RoomDto;
import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.dto.validation.OnUpdate;
import com.orlovandrei.hotel.mapper.RoomMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
@Tag(name = "Room Controller", description = "Room API")
public class RoomController {

    private final RoomService roomService;

    private final RoomMapper roomMapper;

    public static final String FIND_BY_ID = "/api/v1/rooms/{id}";
    public static final String FIND_ALL = "/api/v1/rooms";
    public static final String CREATE = "/api/v1/rooms";
    public static final String UPDATE = "/api/v1/rooms/{id}";
    public static final String DELETE = "/api/v1/rooms/{id}";

    @GetMapping(FIND_BY_ID)
    @Operation(summary = "Get RoomDto by id")
    public RoomDto getById(@PathVariable Long id) {
        Room room = roomService.getById(id);
        return roomMapper.toDto(room);
    }

    @GetMapping(FIND_ALL)
    @Operation(summary = "Get all rooms")
    public List<RoomDto> getAll() {
        List<Room> rooms = roomService.getAll();
        return roomMapper.toDto(rooms);
    }

    @PostMapping(CREATE)
    @Operation(summary = "Create a new room")
    public RoomDto create(@Validated(OnCreate.class) @RequestBody RoomDto roomDto) {
        Room room = roomMapper.toEntity(roomDto);
        Room createdRoom = roomService.create(room);
        return roomMapper.toDto(createdRoom);
    }

    @PutMapping(UPDATE)
    @Operation(summary = "Update an existing room")
    public RoomDto update(@PathVariable Long id, @Validated(OnUpdate.class) @RequestBody RoomDto roomDto) {
        Room room = roomMapper.toEntity(roomDto);
        Room updatedRoom = roomService.update(id, room);
        return roomMapper.toDto(updatedRoom);
    }

    @DeleteMapping(DELETE)
    @Operation(summary = "Delete room")
    public void deleteById(@PathVariable Long id) {
        roomService.delete(id);
    }
}
