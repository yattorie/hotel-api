package com.orlovandrei.hotel.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceMessages {
    //NOT FOUND
    BOOKING_NOT_FOUND("Booking not found with id: "),
    EMPLOYEE_NOT_FOUND("Employee not found with id: "),
    ROOM_NOT_FOUND("Room not found with id: "),
    ROOM_OCCUPIED("Room is already occupied"),
    INVENTORY_NOT_FOUND("Inventory not found with id: "),
    REVIEW_NOT_FOUND("Review not found with id: "),
    MAINTENANCE_NOT_FOUND("Maintenance not found with id: "),
    USER_NOT_FOUND("User not found with id:"),
    USER_NOT_FOUND_USERNAME("User not found with username: "),
    USER_NOT_FOUND_EMAIL("User not found with email: "),
    USERNAME("Username "),
    EMAIL("Email "),
    IS_ALREADY_TAKEN(" is already taken."),
    NO_USER_FOUND("No user found"),

    //CONSTRUCTED
    BOOKING_CONSTRUCTED("BookingService has been constructed."),
    AUTHENTICATION_CONSTRUCTED("AuthenticationService has been constructed."),
    EMPLOYEE_CONSTRUCTED("EmployeeService has been constructed."),
    INVENTORY_CONSTRUCTED("InventoryService has been constructed."),
    JWT_CONSTRUCTED("JwtService has been constructed."),
    MAINTENANCE_CONSTRUCTED("MaintenanceService has been constructed."),
    REVIEW_CONSTRUCTED("ReviewService has been constructed."),
    ROOM_CONSTRUCTED("RoomService has been constructed."),
    USER_CONSTRUCTED("UserService has been constructed.");

    private final String message;
}