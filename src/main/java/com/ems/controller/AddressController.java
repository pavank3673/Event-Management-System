package com.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ems.entity.Address;
import com.ems.service.AddressService;

@Controller
public class AddressController {

	private final AddressService addressService;

	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@RequestMapping("/add-address-view")
	public ModelAndView addAddressView(@RequestParam int eventId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("add_address.jsp");
		mav.addObject("address", new Address());
		mav.addObject("eventId", eventId);

		return mav;
	}

	@RequestMapping(path = "/add-address", method = RequestMethod.POST)
	public ModelAndView addAddress(Address address, @RequestParam int eventId) {
		addressService.addAddress(address,eventId);
		return new ModelAndView("redirect:/request-update-event?eventId="+eventId);
	}

	@RequestMapping("/request-update-address")
	public ModelAndView requestUpdateAddress(@RequestParam int addressId, @RequestParam int eventId) {
		Address address = addressService.findAddressById(addressId);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("update_address.jsp");
		mav.addObject("address",address);
		mav.addObject("eventId",eventId);

		return mav;
	}

	@RequestMapping(path = "/update-address", method = RequestMethod.POST)
	public ModelAndView updateAddress(Address address, @RequestParam int eventId) {
		addressService.updateAddress(address);
		return new ModelAndView("redirect:/request-update-event?eventId="+eventId);
	}

	@RequestMapping("/delete-address")
	public ModelAndView deleteAddress( @RequestParam int addressId,@RequestParam int eventId) {
		addressService.deleteAddress(addressId,eventId);
		return new ModelAndView("redirect:/request-update-event?eventId="+eventId);
	}
}
