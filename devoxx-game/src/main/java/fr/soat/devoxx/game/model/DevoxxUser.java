package fr.soat.devoxx.game.model;

import com.google.common.base.Strings;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DEVOXX_USER")
public class DevoxxUser implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long userId;

    @Column(name = "NAME", unique = true, nullable = false)
    String username;

    @Column(name = "FORNAME")
    String userForname;

    @Column(name = "EMAIL")
    String userEmail;

    @Column(name = "REGLEMENT_ACCEPTED")
    boolean reglementAccepted;

    @Column(name = "COMMERCIAL_ACCEPTED")
    boolean commercialEmailAccepted;

    @Column(name = "NEWS_ACCEPTED")
    boolean nextEventsAccepted;

    @Column(name = "QRCODE_ACCPETED")
    boolean isAcceptedQrCode;
    
    @Column(name = "IS_ENABLED")
    boolean enabled = false;

    long score;
    long totalTime;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_USER_ROLES", joinColumns = @JoinColumn(name = "ID_USER"), inverseJoinColumns = @JoinColumn(name = "ID_ROLE"))
    Set<UserRole> userRoles = new HashSet<UserRole>();


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserForname() {
        return userForname;
    }

    public void setUserForname(String userForname) {
        this.userForname = userForname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        for (UserRole role : this.getUserRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }        
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return username;
    }

    @Override
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String userName) {
        this.username = userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }   
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public void addUserRole(UserRole userRole) {
        this.userRoles.add(userRole);
    }

    public void setReglementAccepted(boolean reglementAccepted) {
        this.reglementAccepted = reglementAccepted;
    }

    public boolean isReglementAccepted() {
        return reglementAccepted;
    }
    
    @Transient
    public String getMailHash() {
        String n_email = Strings.isNullOrEmpty(userEmail) ? "" : userEmail.trim().toLowerCase();
        return DigestUtils.md5Hex(n_email);
    }   

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (commercialEmailAccepted ? 1231 : 1237);
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result + (reglementAccepted ? 1231 : 1237);
        result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
        result = prime * result + ((userForname == null) ? 0 : userForname.hashCode());
        result = prime * result + ((userRoles == null) ? 0 : userRoles.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DevoxxUser other = (DevoxxUser) obj;
        if (commercialEmailAccepted != other.commercialEmailAccepted)
            return false;
        if (enabled != other.enabled)
            return false;
        if (reglementAccepted != other.reglementAccepted)
            return false;
        if (userEmail == null) {
            if (other.userEmail != null)
                return false;
        } else if (!userEmail.equals(other.userEmail))
            return false;
        if (userForname == null) {
            if (other.userForname != null)
                return false;
        } else if (!userForname.equals(other.userForname))
            return false;
        if (userRoles == null) {
            if (other.userRoles != null)
                return false;
        } else if (!userRoles.equals(other.userRoles))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DevoxxUser [userId=" + userId + ", username=" + username + ", userForname=" + userForname + ", userEmail=" + userEmail + ", reglementAccepted="
                + reglementAccepted + ", commercialEmailAccepted=" + commercialEmailAccepted + ", nextEventsAccepted=" + nextEventsAccepted
                + ", isAcceptedQrCode=" + isAcceptedQrCode + ", enabled=" + enabled + ", userRoles=" + userRoles + "]";
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public void addToScore(long points) {
        score += points;
    }

    public void addToTime(long timeToAdd) {
        totalTime += timeToAdd;
    }
}
