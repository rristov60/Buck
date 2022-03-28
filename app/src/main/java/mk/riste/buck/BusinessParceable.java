package mk.riste.buck;

import android.os.Parcel;
import android.os.Parcelable;

public class BusinessParceable implements Parcelable {

    protected BusinessParceable(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BusinessParceable> CREATOR = new Creator<BusinessParceable>() {
        @Override
        public BusinessParceable createFromParcel(Parcel in) {
            return new BusinessParceable(in);
        }

        @Override
        public BusinessParceable[] newArray(int size) {
            return new BusinessParceable[size];
        }
    };
}
