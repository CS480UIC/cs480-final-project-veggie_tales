package photo.service;

import photo.dao.PhotoDao;
import photo.domain.Photo;

/**
 * logic functions such as register, login
 * 
 * @author Aayush Makharia
 *
 */
public class PhotoService {
	private PhotoDao photoDao = new PhotoDao();

	/**
	 * register a Photo
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void create(Photo form)
			throws PhotoException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the primary key of Photo
		Photo photo = photoDao.findById(form.getPhotoId());
		if (photo.getPhotoId() != null && photo.getPhotoId().equals(form.getPhotoId()))
			throw new PhotoException("This photo ID is already in use!");
		photoDao.add(form);
	}

	/**
	 * Login function
	 * 
	 * @param form
	 * @return
	 * @throws UserException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void login(Photo form)
			throws PhotoException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Photo id = photoDao.findById(form.getPhotoId());
		if (id.getPhotoId() == null)
			throw new PhotoException("The photo ID is not in the database");

		String date_taken = id.getDateTaken();

		if (date_taken != null && !date_taken.equals(form.getDateTaken()))
			throw new PhotoException(" The date_taken does not exist");
	}
}
